const delete_btn = document.getElementById('btn-delete');

if(delete_btn) {
    delete_btn.addEventListener('click', event=>{
        let id = document.getElementById('article-id').value;
        fetch(`/api/article/${id}`, {
            method:'DELETE'
        })
        .then(()=>{
            alert('삭제가 완료되었습니다.');
            location.replace('/articles');
        });
    });
}

const modify_btn = document.getElementById('modify-btn');
if(modify_btn) {
    modify_btn.addEventListener('click', event=>{
        let params = new URLSearchParams(location.search);
        let id = params.get('id');

        fetch(`/api/articles/${id}`, {
            method:'PUT',
            headers:{
                'Content-Type':'application/json',
            },
            body:JSON.stringify({
                title:document.getElementById('title').value,
                content:document.getElementById('content').value
            })
        })
        .then(()=>{
            alert('수정 완료 되었습니다.');
            location.replace(`/articles/${id}`);
        });
    });

}