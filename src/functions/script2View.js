document.addEventListener('DOMContentLoaded', function () {
    const infoPages = document.querySelectorAll('.info-page');
    const prevButton = document.getElementById('prevPage');
    const nextButton = document.getElementById('nextPage');
    let currentPage = 0;

    function showPage(pageIndex) {
        infoPages.forEach((page, index) => {
            if (index === pageIndex) {
                page.style.display = 'block';
            } else {
                page.style.display = 'none';
            }
        });
    }

    function updateButtons() {
        prevButton.disabled = currentPage === 0;
        nextButton.disabled = currentPage === infoPages.length - 1;
    }

    prevButton.addEventListener('click', function () {
        if (currentPage > 0) {
            currentPage--;
            showPage(currentPage);
            updateButtons();
        }
    });

    nextButton.addEventListener('click', function () {
        if (currentPage < infoPages.length - 1) {
            currentPage++;
            showPage(currentPage);
            updateButtons();
        }
    });

    // 초기 페이지 표시
    showPage(currentPage);
    updateButtons();
});