const enviar = document.getElementById("enviarPost")
const okAuth = document.getElementById("autorizado")
const notAuth = document.getElementById("nao-autorizado")

enviar.addEventListener("click", async function(event){

    event.preventDefault()

    try{
        const userData = {
            nameUser: document.getElementById("nameUser").value,
            passwordUser: document.getElementById("passwordUser").value
        }

        const response = await fetch("http://localhost:1200/api/user/loginUser",{
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(userData),
            credentials: 'omit'
        });

        if(response.ok){
            okAuth.style.display = 'block'
        } else if(response.status = 403){
            notAuth.style.display = 'block'
        }
    }
    catch(error){
        console.log(`"Problemas no server: ${error}`)
        notAuth.style.display = "block"
    }
})

document.body.addEventListener('click', function(){
    okAuth.style.display = 'none'
    notAuth.style.display = 'none'
})
