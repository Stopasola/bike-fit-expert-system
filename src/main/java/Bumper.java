import com.github.cschen1205.ess.engine.EqualsClause;
import com.github.cschen1205.ess.engine.KieRuleInferenceEngine;
import com.github.cschen1205.ess.engine.Rule;
import com.github.cschen1205.ess.engine.RuleInferenceEngine;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

class Bumper {

    private static RuleInferenceEngine getsBumperInferenceEngine() throws IOException, ParseException {

        JSONArray array = ReadJson.read_json("src/main/dataknowledge/amortecedor_database.json");
        RuleInferenceEngine rie = new KieRuleInferenceEngine();

        for(int i = 0; i< array.size(); i++){
            JSONObject amortecedor = (JSONObject) array.get(i);
            JSONObject atributos = (JSONObject) amortecedor.get("amortecedor");

            Rule rule = new Rule((String) atributos.get("nome"));

            rule.addAntecedent(new EqualsClause("categoria", (String) atributos.get("categoria")));
            rule.setConsequent(new EqualsClause("utilizacao", (String) atributos.get("utilizacao")));
            rule.setConsequent(new EqualsClause("nome", (String) atributos.get("nome")));
            rie.addRule(rule);
        }

        return rie;
    }


    public static String Inference(String utilizacao, String categoriavalor) throws IOException, ParseException {
        RuleInferenceEngine riebumper = getsBumperInferenceEngine();
        String amortecedor = "";

        if(categoriavalor.equals("entrada") && utilizacao.equals("trilha")) {
            riebumper.addFact(new EqualsClause("categoria", "entrada"));
            riebumper.addFact(new EqualsClause("utilizacao", "trilha"));
        }
        else if(categoriavalor.equals("media") && utilizacao.equals("trilha")) {
            riebumper.addFact(new EqualsClause("categoria", "media"));
            riebumper.addFact(new EqualsClause("utilizacao", "trilha"));
        }
        else if(categoriavalor.equals("premium") && utilizacao.equals("trilha")) {
            riebumper.addFact(new EqualsClause("categoria", "premium"));
            riebumper.addFact(new EqualsClause("utilizacao", "trilha"));
        }
        else {
            amortecedor = "nao";
        }

        if(!amortecedor.equals("nao")) {
            riebumper.infer(); //forward chain
            return riebumper.getFacts().get(riebumper.getFacts().size()-1).toString();
        }
        else {
            return null;
        }
    }
}
