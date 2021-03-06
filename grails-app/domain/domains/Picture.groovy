package domains

class Picture {

    String path

    static hasOne = [product: Product]

    static constraints = {
        path nullable: false
        product nullable: true
    }
}
