# tx_ms

In order to communicate with the API, the following endpoints are created (all endpoints are accesed through url:port and the endpoint name described below).

1. User entity:
  - GET:
    - /users
    - /users/id_user
  - POST:
    - /users
2. Recharge entity:
  - GET y POST:
    - /recharges
3. Payment entity:
  - GET y POST:
    - /payments
4. Movement view:
  - GET:
    - /movements
5. Internal transaction entity:
  - GET y POST:
    - /internal_transactions
6. Balance entity:
  - GET:
    - /balance
    - /balance/id_user -> Shows the current balance of the user identified with id_user.
  - POST:
    - /balance -> This endpoint will dissapear in future implementations

Image example of an endpoint (All other images are stored in the folder endpoints_images)
![endpoint recharge](https://github.com/billetinWallet/tx_ms/blob/main/endpoints_images/post_recharges.png)
