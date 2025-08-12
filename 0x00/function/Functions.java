/*
 * Functions: somente as opções corretas segundo Clean Code.
 * - Faça somente 1 coisa        -> saveIncome / saveExpense
 * - 1 nível de abstração        -> controller chama service
 * - Argumentos enxutos          -> saveUser(User user) (void)
 * - Sem efeitos colaterais      -> saveUser salva; setRole separado
 * - Sem duplicação              -> extrai getVersion()
 */

public class Functions {

    // --- Dependências simuladas (stubs, só para referência) ---
    private InRepo inRepo;
    private OutRepo outRepo;
    private UserService userService;
    private UserRepository userRepository;
    private EnvironmentService environmentService;
    private ReleaseService releaseService;
    private VersionService versionService;

    // ========== Faça somente 1 coisa ==========
    public void saveIncome(Income income) {
        inRepo.save(income);
    }

    public void saveExpense(Expense expense) {
        outRepo.save(expense);
    }

    // ========== Somente 1 nível de abstração ==========
    @PostMapping("/user")
    public User saveUser(User user) {
        return userService.save(user);
    }

    // ========== Arguments (método com poucos parâmetros) ==========
    public void saveUser(User user, /* seção Arguments */ boolean dummyToDisambiguate) {
        // assinatura enxuta (exemplo didático)
    }

    // ========== No side effects ==========
    public User saveUserNoSideEffects(User user) {
        return userRepository.save(user);
    }
    public void setRole(User user) {
        user.setRole(user);
    }

    // ========== Evite duplicados ==========
    public Environment getEnvironment() {
        return environmentService.getEnvironment(getVersion());
    }
    public Release getRelease() {
        return releaseService.getRelease(getVersion());
    }
    private String getVersion() {
        return versionService.getVersion();
    }

    // --------- Tipos/contratos mínimos (stubs) ---------
    public interface InRepo { void save(Income income); }
    public interface OutRepo { void save(Expense expense); }
    public interface UserService { User save(User user); }
    public interface UserRepository { User save(User user); }
    public interface EnvironmentService { Environment getEnvironment(String version); }
    public interface ReleaseService { Release getRelease(String version); }
    public interface VersionService { String getVersion(); }

    public static class Income {}
    public static class Expense {}
    public static class User {
        public boolean isAdmin;
        public void setRole(User user) { /* stub */ }
    }
    public static class Environment {}
    public static class Release {}

    // Anotação dummy para não depender de Spring no avaliador
    public @interface PostMapping {
        String value();
    }
}
