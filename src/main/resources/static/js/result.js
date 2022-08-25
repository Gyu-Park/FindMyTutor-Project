/* pagination */
const ulTag = document.querySelector(".ul");
let totalPages = document.getElementById('totalPage').value;

function element(totalPages, page) {
    let liTag = '';
    let activeLi;
    let beforePages = page - 1;
    let afterPages = page + 1;
    if (page > 1) {
        // let prevPage = page - 1;
        liTag += `<li class="btn prev" onclick="element(totalPages, ${page - 1})" value="${page - 1}"><span><i class="fas fa-angle-left"></i> Prev</span></li>`;
    }

    if (page > 2) {
        liTag += `<li class="numb" onclick="element(totalPages, 1)" value="1"><span>1</span></li>`;
        if (page > 3) {
            liTag += `<li class="dots"><span>...</span></li>`;
        }
    }

    if (page == totalPages && totalPages > 2) {
        beforePages -= 2;
    } else if (page == totalPages - 1 && totalPages > 2) {
        beforePages -= 1;
    }

    if (page == 1) {
        afterPages += 2;
    } else if (page == 2) {
        afterPages += 1;
    }

    for (let pageLength = beforePages; pageLength <= afterPages; pageLength++) {
        if (pageLength > totalPages) {
            continue;
        }
        if (pageLength == 0) {
            pageLength = pageLength + 1;
        }
        if (page == pageLength) {
            activeLi = "active";
        } else {
            activeLi = "";
        }
        liTag += `<li class="numb ${activeLi}" onclick="element(totalPages, ${pageLength})" value="${pageLength}"><span>${pageLength}</span></li>`;
    }

    if (page < totalPages - 1) {
        if (page < totalPages - 2) {
            liTag += `<li class="dots"><span>...</span></li>`;
        }
        liTag += `<li class="numb" onclick="element(totalPages, ${totalPages})" value="${totalPages}"><span>${totalPages}</span></li>`;
    }

    if (page < totalPages) {
        let nextPage = ++page;
        liTag += `<li class="btn next" onclick="element(totalPages, ${nextPage})" value="${nextPage}"><span>Next <i class="fas fa-angle-right"></i></span></li>`;
    }
    ulTag.innerHTML = liTag;
}
var page = document.getElementById('page');
element(totalPages, page.value);

var numb = document.querySelectorAll(".numb");
var btnNext = document.querySelector(".next");
var btnPrev = document.querySelector(".prev");
var method = document.getElementById('method').value;
var subject = document.getElementById('subject').value;
var price = document.getElementById('price').value;

function reload1() {
    for (var i = 0; i < numb.length; i++) {
        numb[i].addEventListener("click", reloadMethod = (e) => {
            page.value = e.currentTarget.getAttribute("value");
            var url = "http://localhost:8080/result?" 
                            + "page=" + page.value 
                            +"&method=" + method 
                            + "&subject=" + subject 
                            + "&price=" + price
            window.location = url;
        });
    }
}

function reload2() {
    btnNext.addEventListener("click", reloadMethod = (e) => {
        page.value = e.currentTarget.getAttribute("value");
        var url = "http://localhost:8080/result?" 
                        + "page=" + page.value 
                        +"&method=" + method 
                        + "&subject=" + subject 
                        + "&price=" + price
        window.location = url;
    });
}

function reload3() {
    btnPrev.addEventListener("click", reloadMethod = (e) => {
        console.log(page.value);
        page.value = e.currentTarget.getAttribute("value");
        var url = "http://localhost:8080/result?" 
                        + "page=" + page.value 
                        +"&method=" + method 
                        + "&subject=" + subject 
                        + "&price=" + price
        window.location = url;
    });
}

reload1();
if(page.value < totalPages)
    reload2();
if(page.value > 1)
    reload3();