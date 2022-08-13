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
            document.getElementById("method").value = "inperson";
        } else if (i == 1) {
            slidePage.style.marginLeft = "-25%";
            document.getElementById("method").value = "online";
        } else if (i == 2) {
            slidePage.style.marginLeft = "-50%";
            document.getElementById("subject").value = "programming";
        } else if (i == 3) {
            slidePage.style.marginLeft = "-50%";
            document.getElementById("subject").value = "math";
        } else {
            slidePage.style.marginLeft = "-50%";
            document.getElementById("subject").value = "english";
        }
        bullet[cur - 1].classList.add("active");
        progressCheck[cur - 1].classList.add("active");
        cur += 1;
    });
}
for (let i = 0; i < submitBtn.length; i++) {
    submitBtn[i].addEventListener("click", function() {
        if (i == 0) {
            document.getElementById("price").value = "40-50";
        } else if (i == 1) {
            document.getElementById("price").value = "50-60";
        } else {
            document.getElementById("price").value = "60-70";
        }
        bullet[cur - 1].classList.add("active");
        progressCheck[cur - 1].classList.add("active");
        cur += 1;
        // setTimeout(function(){
        //     alert("Good!");
        //     location.reload();
        // }, 500);
    });
}