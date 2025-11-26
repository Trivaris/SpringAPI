{
  description = "A very basic flake";

  inputs = {
    nixpkgs.url = "github:nixos/nixpkgs?ref=nixos-unstable";
    gradle-build.url = "github:trivaris/buildGradleApplication";
  };

  outputs =
    { nixpkgs, gradle-build, ... }:
    let
      forAllSystems =
        function:
        let
          mkPkgs =
            system:
            import nixpkgs {
              inherit system;
              overlays = [ gradle-build.overlays.default ];
            };
        in
        nixpkgs.lib.genAttrs [
          "x86_64-linux"
          "aarch64-linux"
        ] (system: function (mkPkgs system));
    in
    {
      devShells = forAllSystems (
        { callPackage, ... }:
        {
          default = callPackage ./shell.nix { };
        }
      );
    };
}
