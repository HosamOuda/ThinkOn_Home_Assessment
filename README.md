<h1> User Application  👥</h1>

<h2> Overall Description 💬 </h3>
<p> It is a Spring Application connected with MongoDB for persistence user handling</p>

<h2> Features 🧾 </h2>
<li> Create user with their (username, first name, last name, email, phone number) following a flexible schema </li>
<li> Get user given user ID/ all users in the system </li>
<li> Update any field in the user profile (one or many fields) </li>
<li> Delete users </li>


<h2> Get it to work 🔧👨‍💻 </h2>
 <ol>
  <li> Download the code and the Postman collection in the repository</li>
  <li> Run the <code>ThinkOnHomeAssessmentApplication</code> and you are all set !!!</li>
 </ol>
 <hr>
 <h5> You will find all the code written in the <code>src/main</code> folder and the flow is as follows <code> Rest controller </code> (that contains the APIs) -> <code>User Service </code> (that has the actual logic) and the <code>user service </code> is using the <code>UsersRepo</code> which subsequently uses the MongoRepository for its database management  </h5>
<h4> All endpoint URLs are provided with examples in the <code> ThinkOn APIs.postman_collection.json </code>  postman collection so it's only required to download it and import it in the postman </h4>
