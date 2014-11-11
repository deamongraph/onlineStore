class Cart {

    Date date

    static hasOne = [usuario: User]
    static belongsTo = [Product]
    static hasMany = [products: Product]

    static constraints = {
    }
}
