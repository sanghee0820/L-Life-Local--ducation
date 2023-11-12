// 문서 전체에서 클릭 이벤트를 감지합니다.

function toggleList() {
    var categoryList = document.getElementById("categoryList");
    if (categoryList.style.display === "block") {
        categoryList.style.display = "none";
    } else {
        categoryList.style.display = "block";
    }
}

function area_click(button) {
    var selectedArea = button.textContent; // 선택한 버튼의 텍스트 내용 가져오기
    var localSelect = document.getElementById("localSelect");

    // 선택한 지역을 "지역 선택" 요소에 업데이트
    localSelect.textContent = selectedArea;


    // 선택한 항목을 숨김
    var categoryList = document.getElementById("categoryList");
    categoryList.style.display = "none";
}

document.addEventListener("DOMContentLoaded", function () {
    var getLocationButton = document.getElementById("getLocationButton");
    getLocationButton.addEventListener("click", getLocation);
});

function getLocation() {
    if ("geolocation" in navigator) {
        navigator.geolocation.getCurrentPosition(function (position) {
            var latitude = position.coords.latitude;
            var longitude = position.coords.longitude;
            alert("현재 위치 - 위도: " + latitude + ", 경도: " + longitude);
        });
    } else {
        alert("Geolocation을 지원하지 않는 브라우저입니다.");
    }
}