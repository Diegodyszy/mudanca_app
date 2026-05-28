async function listaUsuarios(){
  try{
    const resposta = await fetch('http://localhost:8080/user');
    const users = await resposta.json();

    const corpoTabela = document.getElementById('corpoTabela');

    console.log(users);

    corpoTabela.innerHTML = "";

    users.forEach(usuario =>{
      corpoTabela.innerHTML += `
        <tr>
          <td>${usuario.nome}</td>
          <td>${usuario.telefone}</td>
          <td>${usuario.endereco}</td>
          <td>${usuario.email}</td>
          <td>
            <button class="btn-excluir">Excluir</button>
          </td>
        </tr>
      `;
    })
  } catch (error){
    console.log(error);
  }
}

listaUsuarios();

const btnexcluir = document.querySelectorAll('.btn-excluir');

