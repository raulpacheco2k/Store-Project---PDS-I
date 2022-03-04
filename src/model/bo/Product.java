/*
 * Copyright (c) 2022.
 * Raul Pacheco Domingos (raulpacheco2k)
 * https://github.com/raulpacheco2k
 * https://linkedin.com/in/raulpacheco2k/
 * https://twitter.com/raulpacheco2k
 */

package model.bo;

public class Product extends Model {
    private int id;
    private String description;
    private float value;
    private int brand_id;
    private int product_type;
    private int product_size;

    public Product() {
        setTable("produto");
    }

    public Product(int id, String description, float value, int brand_id, int product_type, int product_size) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.brand_id = brand_id;
        this.product_type = product_type;
        this.product_size = product_size;
        setTable("produto");
    }

    public int getId() {
        return id;
    }

    public Product setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public float getValue() {
        return value;
    }

    public Product setValue(float value) {
        this.value = value;
        return this;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public Product setBrand_id(int brand_id) {
        this.brand_id = brand_id;
        return this;
    }

    public int getProduct_type() {
        return product_type;
    }

    public Product setProduct_type(int product_type) {
        this.product_type = product_type;
        return this;
    }

    public int getProduct_size() {
        return product_size;
    }

    public Product setProduct_size(int product_size) {
        this.product_size = product_size;
        return this;
    }

    @Override
    public String insert() {
        return "INSERT INTO " + getTable() + "(descricaoProduto, valProduto, marca_idmarca, tipoProduto_idtipoProduto, tamanho_idtamanho) VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    public String findAll() {
        return "SELECT idproduto, descricaoProduto, valProduto, marca_idmarca, tipoProduto_idtipoProduto, tamanho_idtamanho FROM" + getTable();
    }

    @Override
    public String findById() {
        return "SELECT idproduto, descricaoProduto, valProduto, marca_idmarca, tipoProduto_idtipoProduto, tamanho_idtamanho FROM " + getTable() + " WHERE idproduto = ?";
    }

    @Override
    public String findByField(String string) {
        return "SELECT idproduto, descricaoProduto, valProduto, marca_idmarca, tipoProduto_idtipoProduto, tamanho_idtamanho FROM " + getTable() + " WHERE " + string + " = ?";
    }

    @Override
    public String update() {
        return "UPDATE " + getTable() + " SET descricaoProduto = ?, valProduto = ?, marca_idmarca = ?, tipoProduto_idtipoProduto = ?, tamanho_idtamanho = ? WHERE idproduto = ?";
    }

    @Override
    public String delete() {
        return null;
    }
}
