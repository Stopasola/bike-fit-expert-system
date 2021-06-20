package com.example.helloworld;
import com.github.cschen1205.ess.engine.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.Scanner;

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
        RuleInferenceEngine rie = getFrameInferenceEngine();
        //RuleInferenceEngine rie = getRelacaoInferenceEngine();

        //rie.addFact(new EqualsClause("coroas", "3x7"));

//Quadro
//        rie.addFact(new EqualsClause("categoria", "15"));
//        rie.addFact(new EqualsClause("desenho", "F"));

//Freio
//        rie.addFact(new EqualsClause("modelo", "v-brake"));

//Pneu
//        rie.addFact(new EqualsClause("categoria", "slick"));
//        rie.addFact(new EqualsClause("largura", "1.5"));
//        rie.addFact(new EqualsClause("nome", "pneu-misto"));


//        System.out.println("before inference");
//        System.out.println(rie.getFacts());
//        System.out.println();
//
//        rie.infer(); //forward chain
//
//        System.out.println("after inference");
//        System.out.println(rie.getFacts());
//        System.out.println();


        Scanner s = new Scanner(System.in);
        System.out.println("Qual é seu genero?");
        String value1 = s.nextLine();

        System.out.println("Qual é sua altura?");
        String val = s.nextLine();
        Float value2 = Float.parseFloat(val);

        if(value1.equals("F")){
            System.out.println("Aqui1");
            if( value2 <= 1.60){
                rie.addFact(new EqualsClause("categoria", "15"));
                rie.addFact(new EqualsClause("desenho", value1));
            } else if(value2 >= 1.60 && value2 <= 1.75){
                System.out.println("Aqui");
                rie.addFact(new EqualsClause("categoria", "17"));
                rie.addFact(new EqualsClause("desenho", value1));
            } else if(value2 > 1.75){
                rie.addFact(new EqualsClause("categoria", "19"));
                rie.addFact(new EqualsClause("desenho", value1));
            }
        }
        else if(value1.equals("M")){
            System.out.println("Aqui3");
            if( value2 <= 1.60){
                rie.addFact(new EqualsClause("categoria", "15"));
                rie.addFact(new EqualsClause("desenho", value1));
            } else if(value2 >= 1.60 && value2 <= 1.75){
                rie.addFact(new EqualsClause("categoria", "17"));
                rie.addFact(new EqualsClause("desenho", value1));
            } else if(value2 > 1.75){
                rie.addFact(new EqualsClause("categoria", "19"));
                rie.addFact(new EqualsClause("desenho", value1));
            }
        }

        System.out.println("before inference");
        System.out.println(rie.getFacts());
        System.out.println();

        rie.infer(); //forward chain

        System.out.println("after inference");
        System.out.println(rie.getFacts());
        System.out.println();

        // Apenas o resultado da inferência
        System.out.println(rie.getFacts().get(rie.getFacts().size()-1));

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
