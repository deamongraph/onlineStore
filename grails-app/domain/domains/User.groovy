package domains

class User {

    String firstname
    String lastname
    String mail
    String username
    String password

    static hasOne = [cart: Cart]
    static belongsTo = [UserRole]
    static hasMany = [usertype: UserRole]

    static constraints = {
        firstname blank: false
        lastname blank: false
        username blank: false, unique: true
        password blank: false
        usertype nullable: false
        cart nullable: true
    }
}
