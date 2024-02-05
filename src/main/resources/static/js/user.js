let index = {
    init: function() {
        $("#btn-save").on("click", () => {
            this.save();
        });
        $("#btn-update").on("click", () => {
            this.update();
        });
        $("#sub-create").on("click", () => {
            this.create();
        });
        $("#sub-update").on("click", () => {
            this.sub_update();
        });
        $("#use-storage").on("click" , () => {
            this.use_storage();
        })
    },

    save: function() {
        let data = {
            username: $("#username").val(),
            password: $("#pwd1").val(),
            password1 : $("#pwd2").val(),
            email: $("#email").val()
        };



        if(data.username === "") {
            alert("아이디를 입력해주세요");
            return 0;
        }

        if(data.password === "") {
            alert("비밀번호를 입력해주세요");
            return 0;
        }else if(data.password !== data.password1){
            alert("비밀번호가 일치 하지 않습니다.");
            return 0;
        }

        if(data.email === "") {
            alert("이메일을 입력해주세요");
            return 0;
        }

        $.ajax({
            type: "POST",
            url: "/auth/joinProc",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp) {
            alert("회원가입이 완료되었습니다.");
            location.href = "/";
            console.log(resp);
        }).fail(function(error) {
            alert("존재하는 ID 또는 존재하는 이메일입니다.");
            return 0;
        });
    },

    update: function() {
        let data = {
            username: $("#username").val(),
            password: $("#password1").val(),
            password1 : $("#password2").val(),
            email: $("#email").val()
        };

        if(data.password === "") {
            alert("비밀번호를 입력해주세요");
            return 0;
        }else if(data.password !== data.password1){
            alert("비밀번호가 일치 하지 않습니다.");
            return 0;
        };

        if(data.email === "") {
            alert("이메일을 입력해주세요");
            return 0;
        };


        $.ajax({
            type: "PUT",
            url: "/auth/user",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp) {
            alert("회원수정이 완료 되었습니다. 다시 로그인 해주십시요");
            location.href = "/logout";
        }).fail(function(error) {
            alert("사용중인 email입니다.")
            return 0;
        });
    },

    create: function() {
        let data = {
            username : $("#username").val(),
            numberOfUsers: $("#numberOfUsers").val(),
            subscriptionPeriod: $("#subscriptionPeriod").val(),
            useStorageCapacity : 0.0,
            serviceType : $("#serviceType").val(),
            companyName: $("#companyName").val(),
            phoneNumber: $("#phoneNumber").val(),
            email: $("#email").val(),
            address: $("#address").val()
        };

        $.ajax({
            type: "POST",
            url: "/subscription/create",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp) {
            alert("구독신청이 완료 되었습니다.");
            console.log(data);
            location.href = "/success";
        }).fail(function(error) {
            alert("구독신청이 실패 하였습니다.");

        });
    },

    use_storage: function() {
        fileSize : $("#fileInput").val()

        let fileSizeInBytes = 0;
        let fileSizeInMB = 0;

        if (fileInput.files.length > 0) {
            fileSizeInBytes = fileInput.files[0].size;
            fileSizeInMB = fileSizeInBytes / (1024 * 1024);
        };

        if(fileSizeInMB == 0) {
            alert("파일 업로드에 실패하였습니다.")
            return 0;
        }

        let data = {
            username : $("#username").val(),
            useStorageCapacity : fileSizeInMB
        };

        $.ajax({
            type: "PUT",
            url: "/subscription/useUpdate",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function() {
            alert("저장이 완료 되었습니다.");
            location.href = "/success";
        }).fail(function() {
            alert("저장이 실패 하였습니다.")
        });
    },

    sub_update: function() {
        let data = {
            username : $("#username").val(),
            subscriptionPeriod: $("#subscriptionPeriod").val(),
            serviceType : $("#serviceType").val()
        };

        $.ajax({
            type:"PUT",
            url : "/subscription/modify",
            data : JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp) {
            alert("구독 연장 신청이 완료되었습니다.");
            location.href = "/success";
        }).fail(function(error) {
            console.log(error);
            alert("구독 연장 신청이 실패하였습니다.")
        });
    }
};

index.init();
