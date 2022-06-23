package tests;

import actions.CadastroActions;
import com.codeborne.selenide.Configuration;
import models.CadastroModel;
import models.MensagensModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CadastroTest {
    private static CadastroActions cadastro;

    @BeforeMethod
    public void start() {

        cadastro = new CadastroActions();
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://buger-eats-qa.vercel.app";

        cadastro.acessaApp("/deliver");
    }

    @Test
    public void deveCadastrarUmNovoEntregador() {

        CadastroModel dadosCadastrais = new CadastroModel(
                "fabiano",
                "33322255566",
                "fabianofda@deliver.io",
                "9999999999",
                "06382090",
                "Rua Yukio Wada",
                "1000",
                "A10",
                "Vila Silviânia",
                "Carapicuíba/SP",
                "Moto",
                "../Selenide/src/main/resources/files/cnh-bean.jpeg");

        cadastro
                .preencheFormulario(dadosCadastrais)
                .submeterFormulario()
                .mensagemEpserada("Recebemos os seus dados. Fique de olho na sua caixa de email, pois e em breve retornamos o contato.");

    }

    @Test
    public void deveValidarQuandoCamposObrigatorisNaoForInformados() {

         MensagensModel mensagens = new MensagensModel(
                "É necessário informar o nome",
                "É necessário informar o CPF",
                "É necessário informar o email",
                "É necessário informar o CEP",
                "É necessário informar o número do endereço",
                "Selecione o método de entrega",
                "Adicione uma foto da sua CNH");

        cadastro
                .submeterFormulario()
                .mensagensAlerta(mensagens);

    }

    @Test
    public void deveValidarQuandoEmailForInvalido() {

        CadastroModel dadosCadastrais = new CadastroModel(
                "fabiano",
                "33322255566",
                "fabianofda#deliver.io",
                "9999999999",
                "06382090",
                "Rua Yukio Wada",
                "1000",
                "A10",
                "Vila Silviânia",
                "Carapicuíba/SP",
                "Moto",
                "../Selenide/src/main/resources/files/cnh-bean.jpeg");
        cadastro
                .preencheFormulario(dadosCadastrais)
                .submeterFormulario()
                .mensagemAlert("Oops! Email com formato inválido.");

    }

    @Test
    public void deveValidarQuandoCepForInvalido() {
        cadastro
                .cepInv("000000000")
                .mensagemAlert("Informe um CEP válido");

    }
}
