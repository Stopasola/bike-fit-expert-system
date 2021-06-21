import com.github.cschen1205.ess.engine.EqualsClause;
import com.github.cschen1205.ess.engine.KieRuleInferenceEngine;
import com.github.cschen1205.ess.engine.Rule;
import com.github.cschen1205.ess.engine.RuleInferenceEngine;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

class Rim {

    private static RuleInferenceEngine getRimInferenceEngine() throws IOException, ParseException {

        JSONArray array = ReadJson.read_json("src/main/dataknowledge/aro_database.json");
        RuleInferenceEngine rie = new KieRuleInferenceEngine();

        for(int i = 0; i< array.size(); i++){
            JSONObject aro = (JSONObject) array.get(i);
            JSONObject atributos = (JSONObject) aro.get("aro");


            Rule rule = new Rule((String) atributos.get("nome"));

            rule.addAntecedent(new EqualsClause("utilizacao", (String) atributos.get("utilizacao")));
            rule.setConsequent(new EqualsClause("nome", (String) atributos.get("nome")));
            rie.addRule(rule);
        }

        return rie;
    }


    public static String Inference(String utilizacao) throws IOException, ParseException {
        RuleInferenceEngine rierim = getRimInferenceEngine();

        if(utilizacao.equals("passeio cidade"))
        {
            rierim.addFact(new EqualsClause("utilizacao", "passeio cidade"));
        }
        else if(utilizacao.equals("viagem"))
        {
            rierim.addFact(new EqualsClause("utilizacao", "longas viagens"));
        }
        else if(utilizacao.equals("trabalho"))
        {
            rierim.addFact(new EqualsClause("utilizacao", "trabalho"));
        }
        else if(utilizacao.equals("cidade"))
        {
            rierim.addFact(new EqualsClause("utilizacao", "estrada de chao/cidade"));
        }
        else if(utilizacao.equals("trilha"))
        {
            rierim.addFact(new EqualsClause("utilizacao", "estrada de chao/trilha"));
        }
        else if(utilizacao.equals("ciclismo de estrada"))
        {
            rierim.addFact(new EqualsClause("utilizacao", "ciclismo de estrada"));
        }

        rierim.infer(); //forward chain
        return rierim.getFacts().get(rierim.getFacts().size()-1).toString();
    }
}
