# Angeles

This is a weird experiment in isometric Clojure(script) apps. Some or none of these ideas are good.

1. Uses msgpack to prevent stupid serialization between JSON and EDN
1. Uses schema because we all know `core.spec` is evil
1. Cljc is the new black, we get DRY if we keep CLJC mostly declarative with simple data structures
1. Do whatever you need in macros to keep hot reloading alive
1. Modular CSS screwed us over on Generosity, Balboa tried a half-baked BEM, Angeles uses inline styles and a simple way of mixing in states
1. Namespaced keywords are bomb 

# Where's the database? Is this Brevity 2?

No. I'm on vacation. Postgres is Monday-to-Friday. [You're in my world grandma.](https://www.youtube.com/watch?v=owNO5s3eln4) This is an experiment.

# What the heck is going on with the CSS?

Modular CSS is pretty cool, but it turns our DOM into a decent into madness. BEM is also pretty cool, but it has a ton of boilerplate and probably means having to place our CSS separately from our CLJS, which is a bummer. 

I attempt to have our cake and eat it to with inline styles. Vjeux and the rest of the React team has gone this way. React Native even goes as far as only allowing inline styles. I tried to leverage some Clojure niceties with maps to make this work for us.
