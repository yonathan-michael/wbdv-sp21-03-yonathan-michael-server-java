(function () {
    var $usernameFld, $passwordFld;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $createBtn, $updateBtn;
    var $userForm;
    var $tbody;
    var userService = new AdminUserServiceClient();
    $(main);

    function main() {
      $usernameFld = $(".wbdv-username-fld")
      $passwordFld = $(".wbdv-password-fld")
      $firstNameFld = $(".wbdv-firstName-fld")
      $lastNameFld = $(".wbdv-lastName-fld")
      $roleFld = $(".wbdv-role-fld")
      $createBtn = $(".wbdv-create-btn")
      $updateBtn = $(".wbdv-update-btn")
      $tbody = $(".wbdv-tbody")
      $userForm = $("wbdv-form")

      $updateBtn.click(updateUser)
//      user = {username: 'JD', password: 'xxxx', firstName: 'John', lastName: 'Doe', role: 'Student'}
//      createUser(user)

      $createBtn.click(() => {
      user = {username: $usernameFld.val(),
                     password: $passwordFld.val(),
                     firstName: $firstNameFld.val(),
                     lastName: $lastNameFld.val(),
                     role: $roleFld.val()
                                        }
        createUser(user)
        $usernameFld.val("")
        $passwordFld.val("")
        $firstNameFld.val("")
        $lastNameFld.val("")
        $roleFld.val("")
      });
    }

    var users = [];

    function createUser(user) {
//      userService.createUser(user).then(function (actualUser){
        users.push(user)
        console.log(users)
        renderUsers(users)
//        })
      }


    function deleteUser(event) {
        console.log(event.target)
        var deleteBtn = jQuery(event.target)
        var theIndex = deleteBtn.attr("id")
////        var theId = users[theIndex]._id
////        userService.deleteUser(theId).then(function (status) {
        users.splice(theIndex, 1)
        renderUsers(users)
////        })
    }

    function updateUser(event) {
        console.log(event.target)
        var updateBtn = jQuery(event.target)
        userToEdit.username = $usernameFld.val()
        userToEdit.password = $passwordFld.val()
        userToEdit.firstName = $firstNameFld.val()
        userToEdit.lastName = $lastNameFld.val()
        userToEdit.role = $roleFld.val()
        var i = (user) => user.username == userToEdit.username
        var index = users.findIndex(i)
        users[index] = userToEdit
        renderUsers(users)
      }

    var userToEdit = null
    function editUser(event) {
        console.log(event.target)
        var editBtn = jQuery(event.target)
        var theId = editBtn.attr("id")
        for (var i = 0; i < users.length; i++) {
            var user = users[i]
            if (i == theId ) {
                userToEdit = user
                break;
            }
        }
        $usernameFld.val(userToEdit.username)
        $passwordFld.val(userToEdit.password)
        $firstNameFld.val(userToEdit.firstName)
        $lastNameFld.val(userToEdit.lastName)
        $roleFld.val(userToEdit.role)
      }

    function renderUsers(users) {
      $tbody.empty();
      for (var i = 0; i < users.length; i++) {
        var user = users[i]
        $tbody.prepend(`
        <tr>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.role}</td>
            <td>
                <i class="fa-2x fa fa-times wbdv-delete-btn" id="${i}"></i>
                <i class="fa-2x fa fa-pencil wbdv-edit-btn" id="${i}"></i>
            </td>
        </tr>
    `)
    }
     $deleteBtn = $(".wbdv-delete-btn")
     $deleteBtn.click(deleteUser)
     $editBtn = $(".wbdv-edit-btn")
     $editBtn.click(editUser)
    }
})();

