var buttonLeft = document.querySelector('.button-left');
var buttonRight = document.querySelector('.button-right');
var item = document.querySelector('.carousel-product');
var index = 0;

buttonLeft.addEventListener('click', (e) => {
    if (index > 0) index--
        item.style.transform = `translateX(${-index*16.67}%)`
})
buttonRight.addEventListener('click', (e) => {
    if (index < item.childElementCount - 1) index++
        item.style.transform = `translateX(${-index*16.67}%)`
})