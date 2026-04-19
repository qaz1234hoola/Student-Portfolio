@Controller
public class PortfolioController {

    @Autowired
    private PortfolioService service;

    @GetMapping("/portfolio")
    public String page() {
        return "portfolio";
    }

    @PostMapping("/portfolio")
    public String save(@RequestParam String bio) {
        service.createPortfolio(bio);
        return "dashboard";
    }
}