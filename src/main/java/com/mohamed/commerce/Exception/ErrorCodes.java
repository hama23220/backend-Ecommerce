package com.mohamed.commerce.Exception;

public enum ErrorCodes {
    ARTICLE_NOT_FOUND(1000),
    ARTICLE_NOT_VALID(1001),
    ARTICLE_ALREADY_IN_USE(1002),

    Brand_NOT_FOUND(2000),
    Brand_NOT_VALID(2001),
    Brand_ALREADY_IN_USE(2002),

    Categorie_NOT_FOUND(3000),
    Categorie_NOT_VALID(3001),
    Categorie_ALREADY_IN_USE(3002),

    CommandeClient_NOT_FOUND(4000),
    CommandeClient_NOT_VALID(4001),
    CommandeClient_ALREADY_IN_USE(4002),
    COMMANDE_CLIENT_NON_MODIFIABLE(4003),


    Declinision_NOT_FOUND(5000),
    Declinision_NOT_VALID(5001),
    Declinision_ALREADY_IN_USE(5002),

    Entreprise_NOT_FOUND(6000),
    Entreprise_NOT_VALID(6001),
    Entreprise_ALREADY_IN_USE(6002),

    LigneCommande_NOT_FOUND(7000),
    LigneCommande_NOT_VALID(7001),
    LigneCommande_ALREADY_IN_USE(7002),

    Panier_NOT_FOUND(8000),
    Panier_NOT_VALID(8001),
    Panier_ALREADY_IN_USE(8002),

    RoleUser_NOT_FOUND(9000),
    RoleUser_NOT_VALID(9001),
    RoleUser_ALREADY_IN_USE(9002),

    Stock_NOT_FOUND(10000),
    Stock_NOT_VALID(10001),
    Stock_ALREADY_IN_USE(10002),

    User_NOT_FOUND(11000),
    User_NOT_VALID(11001),
    User_ALREADY_IN_USE(11002),
    USER_ALREADY_EXISTS(11003)

    ;


    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
