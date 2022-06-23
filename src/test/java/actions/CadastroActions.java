package actions;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import models.CadastroModel;
import models.MensagensModel;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CadastroActions {

    public CadastroActions acessaApp(String rota) {
        Selenide.open(rota);

        return this;
    }

    public CadastroActions preencheFormulario(CadastroModel dadosCadastrais) {
        dados(dadosCadastrais);
        endereco(dadosCadastrais);
        metodoEntrega(dadosCadastrais);

        return this;
    }

    public CadastroActions submeterFormulario() {
        $(byText("Cadastre-se para fazer entregas")).click();

        return this;
    }

    public CadastroActions cepInv(String cep) {
        $("input[name='postalcode']").setValue(cep);
        $("input[value='Buscar CEP']").click();

        return this;
    }

    public SelenideElement mensagemEpserada(String mensagem) {

        return $(".swal2-html-container").shouldHave(text(mensagem));
    }

    public ElementsCollection.SelenideElementIterable mensagensAlerta(MensagensModel mensagens) {

        return $$("span[class='alert-error']").asDynamicIterable();
    }

    public SelenideElement mensagemAlert(String alert) {

        return $("span[class='alert-error']").shouldHave(text(alert));
    }

    private CadastroActions metodoEntrega(CadastroModel dadosCadastrais) {
        $(".delivery-method li").shouldHave(text(dadosCadastrais.metodo)).click();
        $("input[type=file]").uploadFile(new File(dadosCadastrais.imagem));

        return this;
    }

    private CadastroActions endereco(CadastroModel dadosCadastrais) {
        $("input[name='postalcode']").setValue(dadosCadastrais.cep);
        $("input[value='Buscar CEP']").click();
        $("input[name='address']").shouldHave(value(dadosCadastrais.rua));
        $("input[name='address-number']").setValue(dadosCadastrais.numero);
        $("input[name='address-details']").setValue(dadosCadastrais.complemento);
        $("input[name='district']").shouldHave(value(dadosCadastrais.bairro));
        $("input[name='city-uf']").shouldHave(value(dadosCadastrais.cidade));

        return this;
    }

    private CadastroActions dados(CadastroModel dadosCadastrais) {
        $("input[name='fullName']").setValue(dadosCadastrais.nome);
        $("input[placeholder='CPF somente números']").setValue(dadosCadastrais.cpf);
        $("input[name='email']").setValue(dadosCadastrais.email);
        $("input[name='whatsapp']").setValue(dadosCadastrais.whats);

        return this;
    }
}
