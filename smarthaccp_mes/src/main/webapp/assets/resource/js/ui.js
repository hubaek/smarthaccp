window.onload=function(){
    setPopupEvent.init();
};

const setPopupEvent = {
    opt:{
      class:'popupOpen'
    },
    init :  function(){;
        this.setEvent();
        this.body = document.body;
    },
    setEvent: function(){
        const $t = this;
       document.getElementById('productName').addEventListener('focus',function(){
            $t.open();
       })
        document.getElementById('popupLayerCloseButton').addEventListener('focus',function(){
            $t.close();
        })
    },
    open: function() {
        const $t = this;
        if(!$t.body.classList.contains($t.opt.class)) {
            $t.body.classList.add($t.opt.class);
        }
    },
    close: function(){
        const $t = this;
        if($t.body.classList.contains($t.opt.class)) {
            $t.body.classList.remove($t.opt.class);
        }
    }
}
