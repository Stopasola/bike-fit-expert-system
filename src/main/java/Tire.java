import com.github.cschen1205.ess.engine.EqualsClause;
import com.github.cschen1205.ess.engine.KieRuleInferenceEngine;
import com.github.cschen1205.ess.engine.Rule;
import com.github.cschen1205.ess.engine.RuleInferenceEngine;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

class Tire {

    private static RuleInferenceEngine getTireInferenceEngine() throws IOException, ParseException {

        JSONArray array = ReadJson.read_json("src/main/dataknowledge/pneu_database.json");
        RuleInferenceEngine rie = new KieRuleInferenceEngine();

        for(int i = 0; i< array.size(); i++){
            JSONObject pneu = (JSONObject) array.get(i);
            JSONObject atributos = (JSONObject) pneu.get("pneu");


            Rule rule = new Rule((String) atributos.get("nome"));

            rule.addAntecedent(new EqualsClause("categoria", (String) atributos.get("categoria")));
            rule.addAntecedent(new EqualsClause("largura", (String) atributos.get("largura")));
            rule.setConsequent(new EqualsClause("nome", (String) atributos.get("nome")));
            rie.addRule(rule);
        }

        return rie;
    }


    public static String Inference(String utilizacao) throws IOException, ParseException {
        RuleInferenceEngine rietire = getTireInferenceEngine();

        if(utilizacao.equals("passeio cidade"))
        {
            rietire.addFact(new EqualsClause("categoria", "slick"));
            rietire.addFact(new EqualsClause("largura", "1.7"));
        } else if(utilizacao.equals("viagem"))
        {
            rietire.addFact(new EqualsClause("categoria", "misto"));
            rietire.addFact(new EqualsClause("largura", "2.2"));
        } else if(utilizacao.equals("trabalho"))
        {
            rietire.addFact(new EqualsClause("categoria", "misto"));
            rietire.addFact(new EqualsClause("largura", "2.0"));
        } else if(utilizacao.equals("cidade"))
        {
            rietire.addFact(new EqualsClause("categoria", "misto"));
            rietire.addFact(new EqualsClause("largura", "2.2"));
        } else if(utilizacao.equals("trilha"))
        {
            rietire.addFact(new EqualsClause("categoria", "cravado"));
            rietire.addFact(new EqualsClause("largura", "2.5"));
        } else if(utilizacao.equals("ciclismo de estrada")){
            rietire.addFact(new EqualsClause("categoria", "slick"));
            rietire.addFact(new EqualsClause("largura", "1.5"));
        }

        rietire.infer(); //forward chain

        return  rietire.getFacts().get(rietire.getFacts().size()-1).toString();
    }
}
