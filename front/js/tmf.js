var TMF = (function () {

    var showCards = function () {
        console.log("Call submitExample");

        $('#tmf-home').fadeOut(2000, function () {
            $('#tmf-cards').fadeIn(2000);
        });
    }

     var submitExample = function () {
         showCards();
     }

    return {
        submitExample: submitExample
    };

})();
