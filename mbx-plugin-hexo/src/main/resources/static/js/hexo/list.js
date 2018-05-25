$(function () {
    $(".delete").click(function () {
        var $this = $(this);
        var fileId = $this.data("fileId");

        $.ajax({
            url: "/auth/article/delete?_t=" + (new Date().getTime()),
            data: {
                fileId: fileId
            },
            type: "post",
            dataType: "json",
            success: function (data) {
                if (data.success) {
                    alert("成功");
                } else {
                    alert("失败");
                }
            },
            error: function (err) {
                console.log(err)
            }
        });
    });
});