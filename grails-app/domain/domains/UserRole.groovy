package domains

class UserRole {

    String type

    static hasMany = [user: User]

    static constraints = {
        type blank: false
        user nullable: true
    }
}
