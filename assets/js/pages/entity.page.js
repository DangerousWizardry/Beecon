parasails.registerPage('entity', {
  //  ╦╔╗╔╦╔╦╗╦╔═╗╦    ╔═╗╔╦╗╔═╗╔╦╗╔═╗
  //  ║║║║║ ║ ║╠═╣║    ╚═╗ ║ ╠═╣ ║ ║╣
  //  ╩╝╚╝╩ ╩ ╩╩ ╩╩═╝  ╚═╝ ╩ ╩ ╩ ╩ ╚═╝
  data : {
     
    },
  //  ╦  ╦╔═╗╔═╗╔═╗╦ ╦╔═╗╦  ╔═╗
  //  ║  ║╠╣ ║╣ ║  ╚╦╝║  ║  ║╣
  //  ╩═╝╩╚  ╚═╝╚═╝ ╩ ╚═╝╩═╝╚═╝
  beforeMount: function() {

  },
  mounted: async function(){

  },
  //  ╦╔╗╔╔╦╗╔═╗╦═╗╔═╗╔═╗╔╦╗╦╔═╗╔╗╔╔═╗
  //  ║║║║ ║ ║╣ ╠╦╝╠═╣║   ║ ║║ ║║║║╚═╗
  //  ╩╝╚╝ ╩ ╚═╝╩╚═╩ ╩╚═╝ ╩ ╩╚═╝╝╚╝╚═╝
  methods: {
    addEntity : function(entityId){
      let name = $('#disp-'+entityId).val();
      if (name != '') {
        let myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
        const fetchOptions = {
          method: 'PATCH',
          headers: myHeaders,
          body:'{"entityDisplayName": "' + name + '"}'
        }
        
        fetch("http://localhost:4910/dispositifs/"+entityId,fetchOptions)
        .then( (response) => {
          return response.text();
        })
        .then( (text) => {
          console.log(text);
          if (text == "1") {
            $("#message").html('<div class="alert alert-success alert-dismissible fade show" role="alert"><strong>Entité ajouté</strong> Votre nouvel entité a été enregistrée et va être pris en compte dans quelques secondes<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div>');
          }
          else{
            $("#message").html('<div class="alert alert-danger alert-dismissible fade show" role="alert"><strong>Une erreur est survenue</strong> Merci de vérifier vos champs et/ou de réessayer dans quelques secondes<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div>');
          }
          $('.alert').alert();
          setTimeout(function(){window.location.reload()},5000);
        }).catch( (error) => console.log(error))
        }
      
    }
  }
});
