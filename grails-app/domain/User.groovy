class User {

    String firstname
    String lastname
    String username
    String password

    static hasOne = [cart: Cart]
    static belongsTo = [UserType]
    static hasMany = [usertype: UserType]

    static constraints = {
        firstname blank: false
        lastname blank: false
        username blank: false, unique: true
        password blank: false
        usertype nullable: false
        cart nullable: true
    }
}
