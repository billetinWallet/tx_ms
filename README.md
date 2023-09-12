# tx_ms

In order to communicate with the API, the following endpoints are created (all endpoints are accesed through url:port and the endpoint name described below).

1. User entity:
  1.1. GET:
    1.1.1. /users
    1.1.2. /users/id_user
  1.2. POST:
    1.2.1. /users
2. Recharge entity:
  2.1 GET y POST:
    2.1.1. /recharges
3. Payment entity:
  3.1. GET y POST:
    3.1.1. /payments
4. Movement view:
   4.1. GET:
    4.1.1. /movements
5. Internal transaction entity:
  5.1. GET y POST:
    5.1.1. /internal_transactions
6. Balance entity:
  6.1. GET:
    6.1.1. /balance
    6.1.2. /balance/id_user -> Shows the current balance of the user identified with id_user.
  6.2. POST:
    6.2.1. /balance -> This endpoint will dissapear in future implementations

Image example of an endpoint (All other images are stored in the folder endpoints_images)
![endpoint recharge](https://github.com/billetinWallet/tx_ms/blob/main/endpoints_images/post_recharges.png)
