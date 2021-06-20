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


    private static RuleInferenceEngine getMaterialInferenceEngine() throws IOException, ParseException {

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

    public static void testForwardChain() throws IOException, ParseException {
        RuleInferenceEngine rietire = getTireInferenceEngine();
        RuleInferenceEngine riematerial = getMaterialInferenceEngine();
        RuleInferenceEngine riebreak = getBreakInferenceEngine();
        RuleInferenceEngine rieframe = getFrameInferenceEngine();
        RuleInferenceEngine rierelacao = getRelacaoInferenceEngine();

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
        String genero = s.nextLine();

        System.out.println("Qual é sua altura?");
        Float altura = Float.parseFloat(s.nextLine());

        System.out.println("Qual é o valor que você investirá?");
        Float valor = Float.parseFloat(s.nextLine());

        System.out.println("Qual é a utilização que você fará?");
        String utilizacao = s.nextLine();

        String categoriavalor = "";
        String categoriabicicleta = "";

        // Tipo de quadro
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

        // Valor investido na bicileta
        if(valor >= 1200 && valor <= 2200)
        {
            categoriavalor = "entrada";
        }
        else if(valor >= 2201 && valor <= 4500)
        {
            categoriavalor = "medio";
        }
        else if(valor >= 4501 && valor <= 6000)
        {
            categoriavalor = "premium";
        }
        else if(valor >= 6001 && valor <= 7500)
        {
            categoriavalor = "competicao entrada";
        }
        else if(valor >= 7501)
        {
            categoriavalor = "competicao media";
        }

        // Material do quadro
        if(categoriavalor.equals("entrada")){
            riematerial.addFact(new EqualsClause("valor", categoriavalor));
        }else if(categoriavalor.equals("medio")){
            riematerial.addFact(new EqualsClause("valor", categoriavalor));
        }else if(categoriavalor.equals("premium")){
            riematerial.addFact(new EqualsClause("valor", categoriavalor));
        }else if(categoriavalor.equals("competicao entrada")){
            riematerial.addFact(new EqualsClause("valor", categoriavalor));
        }else if(categoriavalor.equals("competicao media")){
            riematerial.addFact(new EqualsClause("valor", categoriavalor));
        }

        // Utilizacao da bicicleta
        if(utilizacao.equals("passeio cidade"))
        {
            categoriabicicleta = "urbana";
        }
        else if(utilizacao.equals("viagem"))
        {
            categoriabicicleta = "cicloturismo";
        }
        else if(utilizacao.equals("trabalho"))
        {
            categoriabicicleta = "cargueira";
        }
        else if(utilizacao.equals("estrada chao cidade"))
        {
            categoriabicicleta = "gravel";
        }
        else if(utilizacao.equals("estrada chao trilha"))
        {
            categoriabicicleta = "mountain bike";
        }
        else if(utilizacao.equals("ciclismo de estrada"))
        {
            categoriabicicleta = "speed";
        }

        // Pneu da bicicleta
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
        } else if(utilizacao.equals("estrada chao cidade"))
        {
            rietire.addFact(new EqualsClause("categoria", "misto"));
            rietire.addFact(new EqualsClause("largura", "2.2"));
        } else if(utilizacao.equals("estrada chao trilha"))
        {
            rietire.addFact(new EqualsClause("categoria", "cravado"));
            rietire.addFact(new EqualsClause("largura", "2.5"));
        } else if(utilizacao.equals("ciclismo de estrada")){
            rietire.addFact(new EqualsClause("categoria", "slick"));
            rietire.addFact(new EqualsClause("largura", "1.5"));
        }

        // Relacao
        if(categoriavalor.equals("entrada") && (utilizacao.equals("passeio cidade") || utilizacao.equals("trabalho"))){
            rierelacao.addFact(new EqualsClause("coroas", "3x7"));
        }
        else if(categoriavalor.equals("medio") && (utilizacao.equals("passeio cidade") || utilizacao.equals("trabalho"))){
            rierelacao.addFact(new EqualsClause("coroas", "3x8"));
        }
        else if(categoriavalor.equals("premium") && (utilizacao.equals("passeio cidade") || utilizacao.equals("trabalho"))){
            rierelacao.addFact(new EqualsClause("coroas", "3x9"));
        }
        else if(categoriavalor.equals("entrada") && (utilizacao.equals("estrada chao cidade") || utilizacao.equals("estrada chao trilha"))){
            rierelacao.addFact(new EqualsClause("coroas", "3x8"));
        }
        else if(categoriavalor.equals("medio") && (utilizacao.equals("estrada chao cidade") || utilizacao.equals("estrada chao trilha"))){
            rierelacao.addFact(new EqualsClause("coroas", "2x9"));
        }
        else if(categoriavalor.equals("premium") && (utilizacao.equals("estrada chao cidade") || utilizacao.equals("estrada chao trilha"))){
            rierelacao.addFact(new EqualsClause("coroas", "1x12"));
        }
        else if(categoriavalor.equals("entrada") && (utilizacao.equals("ciclismo de estrada") || utilizacao.equals("viagem"))){
            rierelacao.addFact(new EqualsClause("coroas", "1x8"));
        }
        else if(categoriavalor.equals("medio") && (utilizacao.equals("ciclismo de estrada") || utilizacao.equals("viagem"))){
            rierelacao.addFact(new EqualsClause("coroas", "1x10"));
        }
        else if(categoriavalor.equals("premium") && (utilizacao.equals("ciclismo de estrada") || utilizacao.equals("viagem"))){
            rierelacao.addFact(new EqualsClause("coroas", "1x11"));
        }

        if(categoriavalor.equals("entrada") && (utilizacao.equals("ciclismo de estrada"))){
            rierelacao.addFact(new EqualsClause("coroas", "3x7"));
        }

        //Inferencia Quadro

        System.out.println("before inference");
        System.out.println(rieframe.getFacts());
        System.out.println();

        rieframe.infer(); //forward chain

        System.out.println("after inference");
        System.out.println(rieframe.getFacts());
        System.out.println();

        // Inferencia Pneu
        System.out.println("before inference");
        System.out.println(rietire.getFacts());
        System.out.println();

        rietire.infer(); //forward chain

        System.out.println("after inference");
        System.out.println(rietire.getFacts());
        System.out.println();

        // Inferencia Material
        System.out.println("before inference");
        System.out.println(riematerial.getFacts());
        System.out.println();

        riematerial.infer(); //forward chain

        System.out.println("after inference");
        System.out.println(riematerial.getFacts());
        System.out.println();

        // Inferencia Relacao
        System.out.println("before inference");
        System.out.println(rierelacao.getFacts());
        System.out.println();

        rierelacao.infer(); //forward chain

        System.out.println("after inference");
        System.out.println(rierelacao.getFacts());
        System.out.println();

        // Apenas o resultado da inferência
        System.out.println(rieframe.getFacts().get(rieframe.getFacts().size()-1));

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
