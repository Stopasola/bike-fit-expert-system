import com.github.cschen1205.ess.engine.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        testForwardChain();
    }

    public static void testForwardChain() throws IOException, ParseException {


        Scanner s = new Scanner(System.in);
        System.out.println("Qual é seu genero?");
        String genero = s.nextLine();

        System.out.println("Qual é sua altura?");
        Float altura = Float.parseFloat(s.nextLine());

        System.out.println("Qual é o valor que você investirá?");
        Float valor = Float.parseFloat(s.nextLine());

        System.out.println("Qual é a utilização que você fará?");
        String utilizacao = s.nextLine();


        /////////////////  Funções de formatação /////////////////

        // Valor investido na bicileta
        String categoriavalor = InvestedValue(valor);

        // Utilizacao da bicicleta
        String categoriabicicleta = BikeCategory(utilizacao);

        /////////////////  Inferencias /////////////////

        // Tipo de quadro
        FrameOutput(Frame.Inference(altura, genero));

        // Material do quadro
        FrameMaterialOutput(FrameMaterial.Inference(categoriavalor));

        // Freio
        BreakOutput(Break.Inference(utilizacao, categoriavalor));

        // Pneu da bicicleta
        TireOutput(Tire.Inference(utilizacao));

        // Relação
        GroupsetOutput(Groupset.Inference(utilizacao, categoriavalor));

        // Amortecedor
        BumperOutput(Bumper.Inference(utilizacao, categoriavalor));

        // Aro
        RimOutput(Rim.Inference(utilizacao));

        //Selim
        SelimOutput(Selim.Inference(utilizacao, categoriabicicleta));

        // Apenas o resultado da inferência
        System.out.println("Bicicleta adequada para você:");

    }

    private static void RimOutput(String rim) {
        rim = rim.split("=")[1];
        System.out.println("Aro: " + rim);
    }

    private static void BreakOutput(String breaks) {
        breaks = breaks.split("=")[1];
        System.out.println("Freio: " + breaks);

    }

    private static void SelimOutput(String selim) {
        selim = selim.split("=")[1];
        System.out.println("Selim: " + selim);
    }

    private static void GroupsetOutput(String groupset) {
        groupset = groupset.split("=")[1];
        System.out.println("Relação: " + groupset);
    }

    private static void FrameMaterialOutput(String material) {
        material = material.split("=")[1];
        System.out.println("Material do quadro: " + material);
    }

    private static void FrameOutput(String frame) {
        frame = frame.split("=")[1];
        System.out.println("Quadro: " + frame);
    }

    private static void TireOutput(String tire) {
        tire = tire.split("=")[1];
        System.out.println("Pneu: " + tire);
    }

    private static void BumperOutput(String bumper) {
        if(bumper == null){
            System.out.println("Não precisa de amortecedor");
        }else {
            bumper = bumper.split("=")[1];
            System.out.println("Amortecedor: " + bumper);
        }
    }

    private static String BikeCategory(String utilizacao) {
        String categoriabicicleta = "";

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
        else if(utilizacao.equals("cidade"))
        {
            categoriabicicleta = "gravel";
        }
        else if(utilizacao.equals("trilha"))
        {
            categoriabicicleta = "mountain bike";
        }
        else if(utilizacao.equals("ciclismo de estrada"))
        {
            categoriabicicleta = "speed";
        }
        return categoriabicicleta;
    }

    private static String InvestedValue(Float valor) {
        String categoriavalor = "";

        if(valor >= 1200 && valor <= 2200)
        {
            categoriavalor = "entrada";
        }
        else if(valor >= 2201 && valor <= 4500)
        {
            categoriavalor = "media";
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
        
        return categoriavalor;
    }
}
