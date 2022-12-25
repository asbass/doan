var mouseOnHover = false;
document.querySelector(".button-left").addEventListener("click", (e) => {
    let list = document.querySelectorAll(".carousel-product .card");
    document.querySelector(".carousel-product").prepend(list[list.length - 1]);
});

document.querySelector(".button-right").addEventListener("click", (e) => {
    let list = document.querySelectorAll(".carousel-product .card");
    document.querySelector(".carousel-product").appendChild(list[0]);
});

document.querySelector(".carousel-box").addEventListener(
    "mouseleave",
    (e) => {
        mouseOnHover = false;
    },
    false
);

document.querySelector(".carousel-box").addEventListener(
    "mouseover",
    (e) => {
        mouseOnHover = true;
    },
    false
);

setInterval(() => {
    let list = document.querySelectorAll(".carousel-product .card");
    if (mouseOnHover === false) {
        document.querySelector(".carousel-product").appendChild(list[0]);
    }
}, 4000);
