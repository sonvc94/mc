<h1>MMS-integrate-for-merchant</h1>

env: java 8
optional: docker

step:
1. implement TransactionCore or modify TransactionImpl to integrate with Merchant System
2. write adapter to convert confirm request to merchant request and merchant response to confirm response 