import com.github.cschen1205.ess.engine.EqualsClause;
import com.github.cschen1205.ess.engine.KieRuleInferenceEngine;
import com.github.cschen1205.ess.engine.Rule;
import com.github.cschen1205.ess.engine.RuleInferenceEngine;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

class Break {

    private static RuleInferenceEngine getBreakInferenceEngine() throws IOException, ParseException {
        JSONArray array = ReadJson.read_json("src/main/dataknowledge/freio_database.json");
        RuleInferenceEngine rie = new KieRuleInferenceEngine();

        for(int i = 0; i< array.size(); i++){
            JSONObject freio = (JSONObject) array.get(i);
            JSONObject atributos = (JSONObject) freio.get("freio");

            Rule rule = new Rule((String) atributos.get("nome"));

            rule.addAntecedent(new EqualsClause("modelo", (String) atributos.get("modelo")));
            rule.addAntecedent(new EqualsClause("valor", (String) atributos.get("valor")));
            rule.setConsequent(new EqualsClause("nome", (String) atributos.get("nome")));
            rie.addRule(rule);
        }

        return rie;
    }


    public static String Inference(String utilizacao, String categoriavalor) throws IOException, ParseException {
        RuleInferenceEngine riebreak = getBreakInferenceEngine();


        if(utilizacao.equals("ciclismo de estrada") && categoriavalor.equals("entrada"))
        {
            riebreak.addFact(new EqualsClause("modelo", "ferradura"));
            riebreak.addFact(new EqualsClause("valor", "entrada"));

        }
        else if(utilizacao.equals("ciclismo de estrada") && categoriavalor.equals("media"))
        {
            riebreak.addFact(new EqualsClause("modelo", "ferradura"));
            riebreak.addFact(new EqualsClause("valor", "media"));
        }
        else if(utilizacao.equals("ciclismo de estrada") && categoriavalor.equals("premium"))
        {
            riebreak.addFact(new EqualsClause("modelo", "ferradura"));
            riebreak.addFact(new EqualsClause("valor", "premium"));
        }
        else
        {
            if(categoriavalor.equals("entrada"))
            {
                riebreak.addFact(new EqualsClause("modelo", "v-brake"));
            }
            else if(categoriavalor.equals("media"))
            {
                riebreak.addFact(new EqualsClause("modelo", "disco-mecanico"));
            }
            else if(categoriavalor.equals("premium"))
            {
                riebreak.addFact(new EqualsClause("modelo", "disco-hidraulico"));
            }
            else if(categoriavalor.equals("competicao entrada"))
            {
                riebreak.addFact(new EqualsClause("modelo", "disco-hidraulico"));
            }
            else if(categoriavalor.equals("competicao media"))
            {
                riebreak.addFact(new EqualsClause("modelo", "disco-hidraulico"));
            }
        }

        riebreak.infer(); //forward chain

        return riebreak.getFacts().get(riebreak.getFacts().size()-1).toString();
    }
}
