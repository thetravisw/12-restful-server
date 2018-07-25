const HOMEPAGE = "http://localhost:8080/whiskies";
const form = document.getElementById("edit-form");
const deleteButton = document.getElementById("delete_whisky");

deleteButton.addEventListener("click", (ev) => {
    fetch(form.action, {
        method: "DELETE"
    }).then(() => {
        window.location = HOMEPAGE;
    });
});

form.addEventListener("submit", (ev) => {
    ev.preventDefault();
    console.log(ev.target.method, ev.target.action);

    const inputs = ev.target.getElementsByTagName("input");
    const name = inputs[0].value;
    const rating = inputs[1].value;
    const whisky = {name, rating};
    const body = JSON.stringify(whisky);

    fetch(ev.target.action, {
        method: ev.target.getAttribute("method"),
        body: body
    }).then(() => {
        window.location = HOMEPAGE;
    });
})
