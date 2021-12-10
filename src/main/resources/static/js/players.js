const allPlayers = [];

const main = document.querySelector("main");

const displayPlayers = (players) => {
   main.innerHTML = players.map(
      (p)=> {
        return asPlayer(p)
      }
  ).join('')
}
function asPlayer(p) {
    let commentHtml = `<div>`

    commentHtml += `<h4>${p} (${p.heading})</h4><br/>`
    commentHtml += `<p>${p.description}</p>`
    commentHtml += `<p>${p.position.name}</p>`
    commentHtml += `</div>`

    return commentHtml
}

fetch(`http://localhost:8080/api/players`).
then(response => response.json()).
then(data => {
    for (let player of data) {
        allPlayers.push(player)
    }
    displayPlayers(allPlayers)
})


