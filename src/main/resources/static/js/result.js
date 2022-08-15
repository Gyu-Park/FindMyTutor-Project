/* pagination */
const ulTag = document.querySelector(".ul");
let totalPages = 20;

function element(totalPages, page) {
    let liTag = '';
    let activeLi;
    let beforePages = page - 1;
    let afterPages = page + 1;
    if (page > 1) {
        liTag += `<li class="btn prev" onclick="element(totalPages, ${page - 1})"><span><i class="fas fa-angle-left"></i> Prev</span></li>`;
    }

    if (page > 2) {
        liTag += `<li class="numb" onclick="element(totalPages, 1)"><span>1</span></li>`;
        if (page > 3) {
            liTag += `<li class="dots"><span>...</span></li>`;
        }
    }

    if (page == totalPages) {
        beforePages -= 2;
    } else if (page == totalPages - 1) {
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
        liTag += `<li class="numb ${activeLi}" onclick="element(totalPages, ${pageLength})"><span>${pageLength}</span></li>`;
    }

    if (page < totalPages - 1) {
        if (page < totalPages - 2) {
            liTag += `<li class="dots"><span>...</span></li>`;
        }
        liTag += `<li class="numb" onclick="element(totalPages, ${totalPages})"><span>${totalPages}</span></li>`;
    }

    if (page < totalPages) {
        liTag += `<li class="btn next" onclick="element(totalPages, ${page + 1})"><span>Next <i class="fas fa-angle-right"></i></span></li>`;
    }
    ulTag.innerHTML = liTag;
}
element(totalPages, 1);

// login form
function openLoginForm() {
    document.body.classList.add("showLoginForm");
}
function closeLoginForm() {
    document.body.classList.remove("showLoginForm");
}

// registration form
function openRegistrationForm() {
    document.body.classList.add("showRegistrationForm");
}
function closeRegistrationForm() {
    document.body.classList.remove("showRegistrationForm");
}

// request form
function openRequestForm() {
    document.body.classList.add("showRequestForm");
}
function closeRequestForm() {
    document.body.classList.remove("showRequestForm");
}

function signUpLinkFunction() {
    document.body.classList.remove("showLoginForm");
    document.body.classList.add("showRegistrationForm");
}

function signInLinkFunction() {
    document.body.classList.remove("showRegistrationForm");
    document.body.classList.add("showLoginForm");
}