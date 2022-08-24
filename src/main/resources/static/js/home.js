const slidePage = document.querySelector(".slidepage");
const nextBtn = document.querySelectorAll(".nextBtn");
const submitBtn = document.querySelectorAll(".submitBtn");
const progressCheck = document.querySelectorAll(".step .check");
const bullet = document.querySelectorAll(".step .bullet");
let max = 3;
let cur = 1;

for (let i = 0; i < nextBtn.length; i++) {
    nextBtn[i].addEventListener("click", function() {
        if (i == 0) {
            slidePage.style.marginLeft = "-25%";
        } else if (i == 1) {
            slidePage.style.marginLeft = "-25%";
        } else if (i == 2) {
            slidePage.style.marginLeft = "-50%";
        } else if (i == 3) {
            slidePage.style.marginLeft = "-50%";
        } else {
            slidePage.style.marginLeft = "-50%";
        }
        bullet[cur - 1].classList.add("active");
        progressCheck[cur - 1].classList.add("active");
        cur += 1;
    });
}
for (let i = 0; i < submitBtn.length; i++) {
    submitBtn[i].addEventListener("click", function() {
        bullet[cur - 1].classList.add("active");
        progressCheck[cur - 1].classList.add("active");
        cur += 1;
        // setTimeout(function(){
        //     alert("Good!");
        //     location.reload();
        // }, 500);
    });
}