# Angeles

This is a weird experiment in isometric Clojure(script) apps. Some or none of these ideas are good.

1. Uses msgpack to prevent stupid serialization between JSON and EDN
1. Uses schema because we all know `core.spec` is evil
1. Cljc is the new black; we get DRY if we keep CLJC as data
1. Do whatever you need in macros to keep hot reloading alive
1. Modular CSS screwed us over on Generosity, Balboa had half-baked BEM, Angeles uses inline styles and mixing in of states
1. Namespaced keywords

# Where's the database? Is this Brevity 2?

No. Postgres is Monday to Friday. This is my vacation. [You're in my world grandma.](https://www.youtube.com/watch?v=owNO5s3eln4)

# What the heck is going on with the CSS?

Modular CSS turns our DOM into madness. BEM is cool, but it has boilerplate and means placing CSS separately from CLJS. 

I attempt to have cake and eat it too with inline styles. The React team has gone this way. React Native even goes as far as to only allow inline styles. I leverage Clojure niceties with maps to make this work.
