package com.example.helloworld;
import com.github.cschen1205.ess.engine.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.Vector;

public class HelloWorld {
    public static void main(String[] args) throws IOException, ParseException {
        testForwardChain();
//        testBackwardChain();
    }

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

    private static RuleInferenceEngine getBreakInferenceEngine() throws IOException, ParseException {
        JSONArray array = ReadJson.read_json("src/main/dataknowledge/freio_database.json");
        RuleInferenceEngine rie = new KieRuleInferenceEngine();

        for(int i = 0; i< array.size(); i++){
            JSONObject freio = (JSONObject) array.get(i);
            JSONObject atributos = (JSONObject) freio.get("freio");

            Rule rule = new Rule((String) atributos.get("nome"));

            rule.addAntecedent(new EqualsClause("modelo", (String) atributos.get("modelo")));
            rule.setConsequent(new EqualsClause("nome", (String) atributos.get("nome")));
            rie.addRule(rule);
        }

        return rie;
    }

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

    private static RuleInferenceEngine getRelacaoInferenceEngine() throws IOException, ParseException {
        JSONArray array = ReadJson.read_json("src/main/dataknowledge/relacao_database.json");
        RuleInferenceEngine rie = new KieRuleInferenceEngine();

        for(int i = 0; i< array.size(); i++){
            JSONObject relacao = (JSONObject) array.get(i);
            JSONObject atributos = (JSONObject) relacao.get("relacao");

            Rule rule = new Rule((String) atributos.get("nome"));

            rule.addAntecedent(new EqualsClause("coroas", (String) atributos.get("coroas")));
            rule.setConsequent(new EqualsClause("nome", (String) atributos.get("nome")));
            rie.addRule(rule);
        }
        return rie;
    }

    public static void testForwardChain() throws IOException, ParseException {
        //RuleInferenceEngine rie = getTireInferenceEngine();
        //RuleInferenceEngine rie = getBreakInferenceEngine();
        //RuleInferenceEngine rie = getFrameInferenceEngine();
        RuleInferenceEngine rie = getRelacaoInferenceEngine();

        rie.addFact(new EqualsClause("coroas", "3x7"));

//Quadro
//        rie.addFact(new EqualsClause("categoria", "15"));
//        rie.addFact(new EqualsClause("desenho", "F"));

//Freio
//        rie.addFact(new EqualsClause("modelo", "v-brake"));

//Pneu
//        rie.addFact(new EqualsClause("categoria", "slick"));
//        rie.addFact(new EqualsClause("largura", "1.5"));
//        rie.addFact(new EqualsClause("nome", "pneu-misto"));

        System.out.println("before inference");
        System.out.println(rie.getFacts());
        System.out.println();

        rie.infer(); //forward chain

        System.out.println("after inference");
        System.out.println(rie.getFacts());
        System.out.println();
    }

    /*public static void testBackwardChain() throws IOException, ParseException {
        RuleInferenceEngine rie=getTireInferenceEngine();
        rie.addFact(new EqualsClause("categoria", "slick"));
        rie.addFact(new EqualsClause("largura", "1.6"));
//        rie.addFact(new EqualsClause("nome", "pneu-misto"));

        System.out.println("Infer: Bike");

        Vector<Clause> unproved_conditions= new Vector<>();

        Clause conclusion=rie.infer("vehicle", unproved_conditions);

        System.out.println("Conclusion: "+conclusion);
    }*/
}
