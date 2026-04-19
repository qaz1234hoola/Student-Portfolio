private PortfolioRepository repository = new PortfolioRepositoryImpl();

public void createPortfolio(String bio) {

    String userId = SessionManager.getUser().getId();

    Portfolio portfolio = new PortfolioBuilder()
            .setUserId(userId)
            .setBio(bio)
            .build();

    repository.save(portfolio);
}

public Portfolio getMyPortfolio() {
    String userId = SessionManager.getUser().getId();
    return repository.findByUserId(userId);
}