import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Name {

    // variáveis que falam por si só  ✅
    public Date modifiedDate;
    public List<Testcase> findAllTestcasesByUser(Name.User user) {
        return new ArrayList<>();
    }

    // Declarações corretas (preferir coleções a arrays)  ✅
    public List<Account> AccountList;

    // Sem Prefixos (nomes de parâmetros claros, sem "pUser")  ✅
    public void deleteUser(Name.User user) {
        // implementação de exemplo
    }

    // Evite mapa mental (nomes autoexplicativos)  ✅
    public URL url;

    // Classe possui nomes próprios; funções com verbos  ✅
    public static class TableRepresent { }
    public void saveCar() {
        // implementação de exemplo
    }

    // Uma palavra por conceito (consistência semântica)  ✅
    public void saveUser() { }
    public void saveAccount() { }
    public void saveContract() { }

    // Use constants/enums em vez de magic numbers/abreviações  ✅
    public static final int DAYS_IN_YEAR = 360;
    public static final int HOURS_IN_WEEK = 168;

    // --- Tipos auxiliares para compilar o exemplo ---
    public static class User { }
    public static class Account { }
    public static class Testcase { }
}
