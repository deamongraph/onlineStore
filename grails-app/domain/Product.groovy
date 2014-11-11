class Product {

    String name
    String description
    Integer availables
    Double price

    static hasMany = [pictures: Picture]

    static constraints = {
        name blank: false, unique: true
        description nullable: true
        availables nullable: false
        price nullable: false
        pictures nullable: false
    }
}
