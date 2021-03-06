package services

import domains.User
import domains.UserRole
import grails.transaction.Transactional

@Transactional
class UserService {

    public User UserAuth(String username, String password){
        return User.findByUsernameAndPassword(username, password)
    }

    public List<User> userList(){
        return User.list()
    }

    public void assignType(String username, String type){
        def user = User.findByUsername(username)
        def usertype = UserRole.findByType(type)
        user.usertype.add(usertype)
        user.save(flush: true)
    }

    public void create(String firstname, String lastname,String mail, String username, String password, String type){
        def user = new User(firstname: firstname, lastname: lastname,mail: mail,
                username: username, password: password,
                usertype: [new UserRole(type: type)]).save(flush: true)
    }

    public void delete(String username){
        def user = User.findByUsername(username).delete()
    }
}