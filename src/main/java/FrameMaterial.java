import com.github.cschen1205.ess.engine.EqualsClause;
import com.github.cschen1205.ess.engine.KieRuleInferenceEngine;
import com.github.cschen1205.ess.engine.Rule;
import com.github.cschen1205.ess.engine.RuleInferenceEngine;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

class FrameMaterial {

    private static RuleInferenceEngine getMaterialsInferenceEngine() throws IOException, ParseException {

        JSONArray array = ReadJson.read_json("src/main/dataknowledge/material_quadro_database.json");
        RuleInferenceEngine rie = new KieRuleInferenceEngine();

        for(int i = 0; i< array.size(); i++){
            JSONObject material = (JSONObject) array.get(i);
            JSONObject atributos = (JSONObject) material.get("material");


            Rule rule = new Rule((String) atributos.get("nome"));

            rule.addAntecedent(new EqualsClause("valor", (String) atributos.get("valor")));
            rule.setConsequent(new EqualsClause("nome", (String) atributos.get("nome")));
            rie.addRule(rule);
        }

        return rie;
    }

    public static String Inference(String valuecategory) throws IOException, ParseException {
        RuleInferenceEngine riematerial = getMaterialsInferenceEngine();

        if(valuecategory.equals("entrada")){
            riematerial.addFact(new EqualsClause("valor", valuecategory));
        }else if(valuecategory.equals("media")){
            riematerial.addFact(new EqualsClause("valor", valuecategory));
        }else if(valuecategory.equals("premium")){
            riematerial.addFact(new EqualsClause("valor", valuecategory));
        }else if(valuecategory.equals("competicao entrada")){
            riematerial.addFact(new EqualsClause("valor", valuecategory));
        }else if(valuecategory.equals("competicao media")){
            riematerial.addFact(new EqualsClause("valor", valuecategory));
        }

        riematerial.infer(); //forward chain

        return riematerial.getFacts().get(riematerial.getFacts().size()-1).toString();
    }
}
