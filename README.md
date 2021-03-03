# IOTManagement
API interview project
The IOT api is a public REST api used to authenticate the scanners attached doors in order to validate their . After the authentication complete the ai will apply some logic to determine if the access to a particular can be granted or not to a person.

##### We have 3 important actions that are occuring with our api:

Authenticate the scanner device attached to a particular door

Authorize access or not to a person by comparing his/her access level against thelevel of access to enter/exit that door

Validatinng that the time at which is badged provides or not access to a particular door.

After the validation and authentication has been completed, we are writting the event data received from the scanner to a mock data.

#### Endpoints

* we have 3 importants that helps us performing all our operations:

  * **POST** `/authenticate`
  This endpoint is called by a device to request a JWT token

  * **POST** ` /access`
  This endpoint is called after a JWt obtained by the device in order to perfom the access checking operation.

  *   **POST** ` /heartbeat`
  This is a simple endpoint to ensure that the scanner is woking as expected.
