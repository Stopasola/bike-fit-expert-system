import com.github.cschen1205.ess.engine.EqualsClause;
import com.github.cschen1205.ess.engine.KieRuleInferenceEngine;
import com.github.cschen1205.ess.engine.Rule;
import com.github.cschen1205.ess.engine.RuleInferenceEngine;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

class Frame {

    private static RuleInferenceEngine getFrameInferenceEngine() throws IOException, ParseException {
        JSONArray array = ReadJson.read_json("src/main/dataknowledge/quadro_database.json");
        RuleInferenceEngine rie = new KieRuleInferenceEngine();


        for(int i = 0; i< array.size(); i++){
            JSONObject quadro = (JSONObject) array.get(i);
            JSONObject atributos = (JSONObject) quadro.get("quadro");

            Rule rule = new Rule((String) atributos.get("nome"));

            rule.addAntecedent(new EqualsClause("categoria", (String) atributos.get("categoria")));
            rule.addAntecedent(new EqualsClause("desenho", (String) atributos.get("desenho")));
            rule.setConsequent(new EqualsClause("nome", (String) atributos.get("nome")));
            rie.addRule(rule);
        }

        return rie;
    }

    public static String Inference(Float altura, String genero) throws IOException, ParseException {
        RuleInferenceEngine rieframe = getFrameInferenceEngine();
        genero = genero.toUpperCase();
        if(genero.equals("F")){

            if( altura >= 1.60 && altura <= 1.65){
                rieframe.addFact(new EqualsClause("categoria", "15"));
                rieframe.addFact(new EqualsClause("desenho", genero));
            } else if(altura > 1.65 && altura < 1.72){
                rieframe.addFact(new EqualsClause("categoria", "17"));
                rieframe.addFact(new EqualsClause("desenho", genero));
            } else if(altura >= 1.72){
                rieframe.addFact(new EqualsClause("categoria", "19"));
                rieframe.addFact(new EqualsClause("desenho", genero));
            }
        }
        else if(genero.equals("M")){

            if( altura >= 1.60 && altura < 1.70){
                rieframe.addFact(new EqualsClause("categoria", "15"));
                rieframe.addFact(new EqualsClause("desenho", genero));
            } else if(altura >= 1.70 && altura < 1.75){
                rieframe.addFact(new EqualsClause("categoria", "17"));
                rieframe.addFact(new EqualsClause("desenho", genero));
            } else if(altura >= 1.75 && altura < 1.80){
                rieframe.addFact(new EqualsClause("categoria", "19"));
                rieframe.addFact(new EqualsClause("desenho", genero));
            } else if(altura >= 1.80){
                rieframe.addFact(new EqualsClause("categoria", "21"));
                rieframe.addFact(new EqualsClause("desenho", genero));
            }
        }

        rieframe.infer(); //forward chain
        return rieframe.getFacts().get(rieframe.getFacts().size()-1).toString();

    }
}
