import com.github.cschen1205.ess.engine.EqualsClause;
import com.github.cschen1205.ess.engine.KieRuleInferenceEngine;
import com.github.cschen1205.ess.engine.Rule;
import com.github.cschen1205.ess.engine.RuleInferenceEngine;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

class Selim {

    private static RuleInferenceEngine getSelimInferenceEngine() throws IOException, ParseException {

        JSONArray array = ReadJson.read_json("src/main/dataknowledge/selim_database.json");
        RuleInferenceEngine rie = new KieRuleInferenceEngine();

        for(int i = 0; i< array.size(); i++){
            JSONObject selim = (JSONObject) array.get(i);
            JSONObject atributos = (JSONObject) selim.get("selim");


            Rule rule = new Rule((String) atributos.get("nome"));

            rule.addAntecedent(new EqualsClause("categoria", (String) atributos.get("categoria")));
            rule.setConsequent(new EqualsClause("nome", (String) atributos.get("nome")));
            rie.addRule(rule);
        }

        return rie;
    }

    public static String Inference(String utilizacao, String categoriabicicleta) throws IOException, ParseException {
        RuleInferenceEngine rieselim = getSelimInferenceEngine();

        if(categoriabicicleta.equals("passeio cidade"))
        {
            rieselim.addFact(new EqualsClause("categoria", "Passeio cidade"));
        }
        else if(categoriabicicleta.equals("viagem"))
        {
            rieselim.addFact(new EqualsClause("categoria", "Longas Viagens"));
        }
        else if(categoriabicicleta.equals("trabalho"))
        {
            rieselim.addFact(new EqualsClause("categoria", "Trabalho"));
        }
        else if(utilizacao.equals("cidade"))
        {
            rieselim.addFact(new EqualsClause("categoria", "Estrada de chão/cidade"));
        }
        else if(utilizacao.equals("trilha"))
        {
            rieselim.addFact(new EqualsClause("categoria", "Estrada de chão/Trilha"));
        }
        else if(utilizacao.equals("ciclismo de estrada"))
        {
            rieselim.addFact(new EqualsClause("categoria", "Ciclismo de estrada"));
        }

        rieselim.infer(); //forward chain
        return rieselim.getFacts().get(rieselim.getFacts().size()-1).toString();
    }
}
