import com.github.cschen1205.ess.engine.EqualsClause;
import com.github.cschen1205.ess.engine.KieRuleInferenceEngine;
import com.github.cschen1205.ess.engine.Rule;
import com.github.cschen1205.ess.engine.RuleInferenceEngine;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

class Groupset {

    private static RuleInferenceEngine getRelacaoInferenceEngine() throws IOException, ParseException {
        JSONArray array = ReadJson.read_json("src/main/dataknowledge/relacao_database.json");
        RuleInferenceEngine rie = new KieRuleInferenceEngine();

        for(int i = 0; i< array.size(); i++){
            JSONObject relacao = (JSONObject) array.get(i);
            JSONObject atributos = (JSONObject) relacao.get("relacao");

            Rule rule = new Rule((String) atributos.get("nome"));

            rule.addAntecedent(new EqualsClause("coroas", (String) atributos.get("coroas")));
            rule.addAntecedent(new EqualsClause("valor", (String) atributos.get("valor")));
            rule.setConsequent(new EqualsClause("utilizacao", (String) atributos.get("utilizacao")));
            rule.setConsequent(new EqualsClause("nome", (String) atributos.get("nome")));
            rie.addRule(rule);
        }
        return rie;
    }



    public static String Inference(String utilizacao, String categoriavalor) throws IOException, ParseException {
        RuleInferenceEngine rierelacao = getRelacaoInferenceEngine();

        if(categoriavalor.equals("entrada") && utilizacao.equals("passeio cidade")){
            rierelacao.addFact(new EqualsClause("coroas", "3x7"));
            rierelacao.addFact(new EqualsClause("valor", "entrada"));
            rierelacao.addFact(new EqualsClause("utilizacao", "passeio cidade"));
        }
        else if(categoriavalor.equals("entrada") && utilizacao.equals("trabalho")){
            rierelacao.addFact(new EqualsClause("coroas", "3x7"));
            rierelacao.addFact(new EqualsClause("valor", "entrada"));
            rierelacao.addFact(new EqualsClause("utilizacao", "trabalho"));
        }
        else if(categoriavalor.equals("media") && utilizacao.equals("passeio cidade")){
            rierelacao.addFact(new EqualsClause("coroas", "3x8"));
            rierelacao.addFact(new EqualsClause("valor", "media"));
            rierelacao.addFact(new EqualsClause("utilizacao", "passeio cidade"));
        }
        else if(categoriavalor.equals("media") && utilizacao.equals("trabalho")){
            rierelacao.addFact(new EqualsClause("coroas", "3x8"));
            rierelacao.addFact(new EqualsClause("valor", "media"));
            rierelacao.addFact(new EqualsClause("utilizacao", "trabalho"));
        }
        else if(categoriavalor.equals("premium") && utilizacao.equals("passeio cidade")){
            rierelacao.addFact(new EqualsClause("coroas", "3x9"));
            rierelacao.addFact(new EqualsClause("valor", "premium"));
            rierelacao.addFact(new EqualsClause("utilizacao", "passeio cidade"));
        }
        else if(categoriavalor.equals("premium") && utilizacao.equals("trabalho")){
            rierelacao.addFact(new EqualsClause("coroas", "3x9"));
            rierelacao.addFact(new EqualsClause("valor", "premium"));
            rierelacao.addFact(new EqualsClause("utilizacao", "trabalho"));
        }
        else if(categoriavalor.equals("entrada") && utilizacao.equals("estrada de chao")){
            rierelacao.addFact(new EqualsClause("coroas", "3x8"));
            rierelacao.addFact(new EqualsClause("valor", "entrada"));
            rierelacao.addFact(new EqualsClause("utilizacao", "estrada de chao"));
        }
        else if(categoriavalor.equals("entrada") && utilizacao.equals("trilha")){
            rierelacao.addFact(new EqualsClause("coroas", "3x8"));
            rierelacao.addFact(new EqualsClause("valor", "entrada"));
            rierelacao.addFact(new EqualsClause("utilizacao", "trilha"));
        }
        else if(categoriavalor.equals("media") && utilizacao.equals("estrada de chao")){
            rierelacao.addFact(new EqualsClause("coroas", "2x9"));
            rierelacao.addFact(new EqualsClause("valor", "media"));
            rierelacao.addFact(new EqualsClause("utilizacao", "estrada de chao"));
        }
        else if(categoriavalor.equals("premium") && utilizacao.equals("trilha")){
            rierelacao.addFact(new EqualsClause("coroas", "1x12"));
            rierelacao.addFact(new EqualsClause("valor", "premium"));
            rierelacao.addFact(new EqualsClause("utilizacao", "trilha"));
        }
        else if(categoriavalor.equals("entrada") && utilizacao.equals("ciclismo de estrada")){
            rierelacao.addFact(new EqualsClause("coroas", "1x8"));
            rierelacao.addFact(new EqualsClause("valor", "entrada"));
            rierelacao.addFact(new EqualsClause("utilizacao", "ciclismo de estrada"));
        }
        else if(categoriavalor.equals("entrada") && utilizacao.equals("viagem")){
            rierelacao.addFact(new EqualsClause("coroas", "1x8"));
            rierelacao.addFact(new EqualsClause("valor", "entrada"));
            rierelacao.addFact(new EqualsClause("utilizacao", "viagem"));
        }
        else if(categoriavalor.equals("media") && utilizacao.equals("ciclismo de estrada")){
            rierelacao.addFact(new EqualsClause("coroas", "1x10"));
            rierelacao.addFact(new EqualsClause("valor", "media"));
            rierelacao.addFact(new EqualsClause("utilizacao", "ciclismo de estrada"));
        }
        else if(categoriavalor.equals("media") && utilizacao.equals("viagem")){
            rierelacao.addFact(new EqualsClause("coroas", "1x10"));
            rierelacao.addFact(new EqualsClause("valor", "media"));
            rierelacao.addFact(new EqualsClause("utilizacao", "viagem"));
        }
        else if(categoriavalor.equals("premium") && utilizacao.equals("ciclismo de estrada")){
            rierelacao.addFact(new EqualsClause("coroas", "1x11"));
            rierelacao.addFact(new EqualsClause("valor", "premium"));
            rierelacao.addFact(new EqualsClause("utilizacao", "ciclismo de estrada"));
        }
        else if(categoriavalor.equals("premium") && utilizacao.equals("viagem")){
            rierelacao.addFact(new EqualsClause("coroas", "1x11"));
            rierelacao.addFact(new EqualsClause("valor", "premium"));
            rierelacao.addFact(new EqualsClause("utilizacao", "viagem"));
        }
        rierelacao.infer(); //forward chain

        return rierelacao.getFacts().get(rierelacao.getFacts().size()-1).toString();
    }
}
